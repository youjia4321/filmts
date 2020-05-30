package com.dream.servlet;

import com.alibaba.fastjson.JSON;
import com.dream.biz.IUserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.utils.ChineseUtil;
import com.dream.utils.CookieUtil;
import com.dream.vo.City;
import com.dream.vo.Province;
import com.dream.vo.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private IUserBiz userBiz = new UserBizImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action"); // 获取操作动作

//        System.out.println(action);

        switch (action) {
            case "getProvinceList": {

                List<Province> provinceList = userBiz.getProvince();

                String jsonStr = JSON.toJSONString(provinceList);

                response.getWriter().println(jsonStr);
            }
                break;
            case "getCityList": {

                String provinceId = (String) request.getParameter("provinceId");
                List<City> cityList = userBiz.getCity(Integer.parseInt(provinceId));
                String jsonStr = JSON.toJSONString(cityList);
                response.getWriter().println(jsonStr);
            }
                break;
            case "isRegister":

                doVerifyUsername(request, response);

                break;
            case "register":

                doRegister(request, response);

                break;
            case "login":

                doLogin(request, response);

                break;
            case "downloadAvatar":

                doDownloadAvatar(request, response);

                break;
            case "logout":

                doLogout(request, response);

                break;
            case "registerAjax": {

                doRegisterAjax(request, response);

            }

        }
    }

    private void doRegisterAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String defaultAvatar = "media" + File.separator + "default" + File.separator + "avatar.jpg";

        String name = request.getParameter("name");

        String password = request.getParameter("password");

        String email = request.getParameter("email");

        String sex = request.getParameter("sex");

        String provinceId = request.getParameter("provinceId");

        String cityId = request.getParameter("cityId");

        User user = new User();

        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setSex(sex);
        user.setProvinceId(Integer.parseInt(provinceId));
        user.setCityId(Integer.parseInt(cityId));
        user.setAvatar(defaultAvatar);
        user.setRoleId(2);

        userBiz.add(user);

        response.getWriter().println("200");
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(); // 清楚session和cookie
        session.removeAttribute("rname");
        session.removeAttribute("name");
        session.removeAttribute("id");
        session.removeAttribute("avatar");

        response.addCookie(CookieUtil.updateCookie("rname", (String)request.getSession().getAttribute("rname"), 0));
        response.addCookie(CookieUtil.updateCookie("name", (String)request.getSession().getAttribute("name"), 0));
        response.addCookie(CookieUtil.updateCookie("id", (String)request.getSession().getAttribute("id"), 0));
        response.addCookie(CookieUtil.updateCookie("avatar", (String)request.getSession().getAttribute("avatar"), 0));

        response.sendRedirect("welcome.jsp");
    }

    private void doDownloadAvatar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");

        // 图片的路径
        String path = "/Users/WangSsyu/IdeaProjects/film-tickets-system/web/media"+
                File.separator + name + File.separator + "avatar.jpg";

        String fileName = path.substring(path.lastIndexOf("/") + 1);

        fileName = URLEncoder.encode(fileName, "UTF-8");

        response.setContentType("image/jpeg");

        // 通过响应告诉浏览器用附件的形式下载
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        InputStream in = new FileInputStream(path);
        ServletOutputStream out = response.getOutputStream();

        byte[] bs = new byte[1024];
        int len;
        while((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }

        in.close();
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException  {
        String name = request.getParameter("name");

        String password = request.getParameter("password");

        String remember = request.getParameter("remember");

        String verity = request.getParameter("verityCode");

//        System.out.println(name+ "" + password + "" + remember + "" + verity);

        // 从session中获取存储的验证码
        String verityCode = (String)request.getSession().getAttribute("verityCode");

        User user = userBiz.isLogin(name, password);

        HashMap<String, Object> map = new HashMap<>();

        if(user != null) {

            if(verity.equalsIgnoreCase(verityCode)) {

                if(remember.equals("on")) { // 记住我
                    response.addCookie(CookieUtil.updateCookie("rname",
                            userBiz.getRoleName(user.getRoleId()), 60*60*24*3));
                    response.addCookie(CookieUtil.updateCookie("name", name, 60*60*24*3));
                    response.addCookie(CookieUtil.updateCookie("id", String.valueOf(user.getId()), 60*60*24*3));
                    response.addCookie(CookieUtil.updateCookie("avatar", user.getAvatar(), 60*60*24*3));

                }

                HttpSession session = request.getSession();

                session.setAttribute("rname", userBiz.getRoleName(user.getRoleId()));
                session.setAttribute("name", user.getName());
                session.setAttribute("avatar", user.getAvatar());
                session.setAttribute("id", user.getId());



                map.put("status", 200);
                map.put("msg", "用户验证成功，正在跳转...");

                String jsonStr = JSON.toJSONString(map);
                response.getWriter().println(jsonStr);

            } else {
                map.put("status", 10001);
                map.put("msg", "验证码错误");

                String jsonStr = JSON.toJSONString(map);
                response.getWriter().println(jsonStr);
            }

        } else { // 登录失败
            map.put("status", 404);
            map.put("msg", "账户或密码错误");

            String jsonStr = JSON.toJSONString(map);
            response.getWriter().println(jsonStr);
        }
    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 文件上传工厂类的对象 因为有图片的上传 所有以流的方式获取数据
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 通过工厂创建一个ServletFileUpload文件上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);

        HashMap<String, Object> map = new HashMap<>();

        String name = null;

        try {
            List<FileItem> fileItemList = upload.parseRequest(request);

            for(FileItem fileItem: fileItemList) {

                if(fileItem.isFormField()) {
                    // 处理文本信息
                    String key = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");

                    if(key.equals("name")) {
                        name = value;
                    }

                    if(map.get(key) == null) {
                        map.put(key, value);
                    } else {
                        // 对于前端多选框来说
                        map.put(name, map.get(name)+","+value);

                    }
                } else {
                    // 处理非文本信息

                    String path = "/Users/WangSsyu/IdeaProjects/film-tickets-system/web/media"+ File.separator + name;

//                    String path = request.getSession().getServletContext().getRealPath("media")
//                            + File.separator + name;

                    File file = new File(path);

                    if(!file.exists()) {
                        file.mkdirs();
                    }

                    String filePath = file.getAbsolutePath() + File.separator + "avatar.jpg";

                    // 输入流
                    InputStream in = fileItem.getInputStream();

                    // 输出流：目的将数据写入本地磁盘
                    FileOutputStream out = new FileOutputStream(filePath);

                    IOUtils.copy(in, out);

                    out.close();

                    map.put("avatar", "media" + File.separator + name + File.separator + "avatar.jpg");

                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // 注册时的map打印
        Set<Map.Entry<String, Object>> set = map.entrySet();
        for (Map.Entry<String, Object> entry : set) {
            System.out.println(entry.getKey()+"----"+entry.getValue());
        }

        User user = new User();

        try {

            // 导入依赖包 beanutils logging
            BeanUtils.populate(user, map);

            userBiz.add(user);

            response.sendRedirect("login.jsp");

        } catch (IllegalAccessException | InvocationTargetException e) {

            e.printStackTrace();

        }

    }

    private void doVerifyUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");

        boolean isContainChinese = ChineseUtil.isContainChinese(name);

        if(!isContainChinese) {

            boolean isRegister = userBiz.isRegister(name);
            if(isRegister) {
                response.getWriter().println("200"); // 可注册
            } else {
                response.getWriter().println("10001"); // 被注册
            }
        } else {
            response.getWriter().println("10002"); // 包含中文
        }
    }
}
