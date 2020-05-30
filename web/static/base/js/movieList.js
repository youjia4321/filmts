layui.use('table', function(){
    const table = layui.table;

    table.render({
        elem: '#demo'
        ,url:'MovieServlet?action=getMovieJson'
        ,cols: [[
            {field:'name',  title: '电影名称'}
            ,{field:'actor',  title: '电影主演'}
            ,{field:'director',  title: '电影导演'}
            ,{field:'type',  title: '电影类型'}
            ,{field:'score', title: '电影评分', sort: true}
            ,{field:'price', title: '电影票价', sort: true}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:100}
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

    table.on('tool(test)', function(obj){
        const data = obj.data;
        if(obj.event === 'choose'){
            layer.msg("选座");
        }
    });
});