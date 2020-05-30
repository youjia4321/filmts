package com.dream.servlet;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CodeServlet")
public class CodeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doVerityCode(request, response);
    }

    private void doVerityCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width = 120;
        int height = 50;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        Graphics graphics = img.getGraphics();

        graphics.setColor(Color.BLUE);

        graphics.fillRect(0, 0, width, height);

        Color[] cs = {Color.GRAY, Color.GREEN, Color.RED, Color.ORANGE};

        String[] code = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};

        StringBuilder stringBuilder = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 4; i++) {

            graphics.setColor(cs[random.nextInt(cs.length)]);

            String randomCode = code[random.nextInt(code.length)];

            graphics.setFont(new Font("宋体", Font.BOLD, random.nextInt(20) + 20));

            graphics.drawString(randomCode, 23 * i, 25 + random.nextInt(5));

            stringBuilder.append(randomCode);

        }

        // 存在session中
        request.getSession().setAttribute("verityCode", stringBuilder.toString());

        graphics.setColor(Color.YELLOW);

        for (int i = 0; i < 5; i++) {
            graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        ImageIO.write(img, "jpg", response.getOutputStream());
    }
}
