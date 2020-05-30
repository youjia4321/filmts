function search() {
    if($("#search").val().trim() === "") {
        alert("请输入关键字！")
    } else {
        alert("暂无此功能！")
    }

}

layui.use('table', function(){
    const table = layui.table;

    table.render({
        elem: '#demo'
        ,toolbar: '#toolbarDemo'
        ,title: '电影列表'
        ,url:'../MovieServlet?action=getMovieJson'
        ,cols: [[
            {field:'name',  title: '电影名称'}
            ,{field:'director',  title: '电影导演'}
            ,{field:'score', title: '电影评分', sort: true}
            ,{field:'price', title: '电影票价', sort: true}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
        ]]
        , layout: ['prev', 'page', 'next', 'skip']
        , page: {
            limit: 10,
            limits: [10,  20, 30]
        }, request: {
            pageName: 'currentPage',
            limitName: 'num'
        }
    });

    // 头工具栏事件
    table.on('toolbar(test)', function(obj){
        const checkStatus = table.checkStatus(obj.config.id);
        if(obj.event === 'add'){
            layer.msg('添加')
        }
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){
        const data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除此电影吗？', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.msg("编辑")
        }
    });
});
