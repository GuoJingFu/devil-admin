$(function () {
    $('#dataTable').bootstrapTable({
        height: "500px",
        queryParams: queryParams,
        columns: [
                {field: 'id',title: 'id',visible: false,align: 'center',valign: 'middle'},
                {field: 'account',title: '账号',align: 'center',valign: 'middle'},
                {field: 'name',title: '名称',align: 'center',valign: 'middle'},
                {field: 'createdAt',title: '创建时间',align: 'center',valign: 'middle'},
                {field: 'isDeleted',title: '是否删除',align: 'center',valign: 'middle'}
        ]
    });
});
//配置参数
function queryParams(params) {
    var temp = {
        pageSize: params.pageSize*1,   //页面大小
        pageStart: params.pageNumber*1 //页码
    };
    return JSON.stringify(temp);
}
