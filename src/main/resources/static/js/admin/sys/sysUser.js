$(function () {
    $('#dataTable').bootstrapTable({
        height: "500px",
        queryParams: queryParams,
        columns: [
                {field: 'id',title: 'id',visible: false,align: 'center',valign: 'middle'},
                {field: 'account',title: '账号',align: 'center',valign: 'middle'},
                {field: 'name',title: '名称',align: 'center',valign: 'middle'},
                {field: 'createdAt',title: '创建时间',align: 'center',valign: 'middle',formatter: dateFormatter},
                {field: 'isDeleted',title: '是否删除',align: 'center',valign: 'middle',formatter: deleteFormatter}
        ]
    });
});
//配置请求参数
function queryParams(params) {
    var temp = {
        pageSize: params.pageSize*1,   //页面大小
        pageStart: params.pageNumber*1 //页码
    };
    return JSON.stringify(temp);
}
//日期格式化
function dateFormatter(value) {
    if (value != null) {
        return new Date(value).pattern("yyyy-MM-dd HH:mm:ss");
    }
    return '';
}
//删除位格式化
function deleteFormatter(value) {
    if (value == 0) {
        return '否';
    } else if (value == 1) {
        return '<span style="color: #f90906; font-weight: bold">是</span>';
    } else {
        return '';
    }
}
