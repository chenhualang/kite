$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
//    var oButtonInit = new ButtonInit();
//    oButtonInit.Init();

});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#warehouse-table').bootstrapTable({
            url: '/kite/warehouses/getWarehouses',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParamsType:"undefined",
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            },{
                field: 'id',
                title: '序号'
            },{
                field: 'fullName',
                title: '转运仓全名'
            },{
                field: 'addressLine',
                title: '转运仓地址'
            },{
                field: 'country',
                title: '国家'
            },{
                field: 'province',
                title: '省/直辖市'
            },{
                field: 'city',
                title: '市/区'
            },{
                field: 'zip',
                title: '邮编'
            },{
                field: 'phoneNumber',
                title: '联系电话'
            },{
                field: 'operate',
                title: '操作',
                formatter: operateFormatter,
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.pageSize,   //页面大小
            pageNo: params.pageNumber  //页码

        };

        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};

function delManyWarehouses(){
    var idstr=[];
    //获取选中的行
    var a= $('#warehouse-table').bootstrapTable('getSelections');
    if(a.length>0){
        if(confirm("您确定要删除选中的数据吗？")){
            $.each(a,function(index){
                idstr.push(a[index].id);
            });
            $.ajax({
                url:'/kite/warehouses/delWarehouses.action',
                dataType:'json',
                type:'post',
                traditional:true,
                data:{
                    ids:idstr
                },
                success:function(data){
                    if(data>0){
                        alert("删除成功！");
                    }else{
                        alert("删除失败！");
                    }
                    $('#warehouse-table').bootstrapTable('refresh');
                },
                error:function(){
                    alert("请求失败！");
                }
            });
        }else{
            return false;
        }
    }else{
        alert("请至少选中一行数据");
    }
}


function operateFormatter(value, row, index) {
    return ['<button type="button" class=" btn btn-primary" onclick="getRole(' + row.id + ')">角色</button>&nbsp;&nbsp;&nbsp;',
        '<button type="button" class=" btn btn-info" onclick="getWarehouseValue(' + row.id + ')">修改</button>',
        '&nbsp;&nbsp;&nbsp;<button class=" btn btn-danger" type="button" onclick="delWarehouse(' + row.id + ')">删除</button>'
    ].join('');
}

//修改前，打开模态框
function getWarehouseValue(id){
    $.ajax({
        url:'warehouses/getWarehouseById.action',
        dataType:'json',
        type:'post',
        data:{
            id:id
        },
        success:function(data){
            $("#warehouse_id").val(data.id);
            $("#warehouse_full_name1").val(data.fullName);
            $("#warehouse_address1").val(data.addressLine);
            $("#warehouse_country1").val(data.country);
            $("#warehouse_province1").val(data.province);
            $("#warehouse_city1").val(data.city);
            $("#warehouse_zip1").val(data.zip);
            $("#warehouse_phone_number1").val(data.phoneNumber);
            $("#updatewarehousedlg").modal('show');
        },
        error:function(){
            alert('请求失败！');
        }
    });
}

    //删除转运仓
function delWarehouse(id){
        if(confirm("您确定要删除这条数据吗?")){
            $.ajax({
                url:'/kite/warehouses/delWarehouse.action',
                dataType:'json',
                type:'post',
                data:{uid:id},
                success:function(data){
                    if(data>0){
                        alert("删除成功！");
                    }else{
                        alert("删除失败！");
                    }
                    $("#warehouse-table").bootstrapTable('refresh');
                },
                error:function(){
                    alert("请求失败！");
                }
            });
        }
    }

//修改转运仓
function updateWarehouse(){
        $.ajax({
            url:'/kite/warehouses/updateWarehouse.action',
            dataType:'json',
            type:'post',
            data:$("#myform1").serialize(),
            success:function(data){
                if(data>0){
                    alert("修改成功！");
                }else{
                    alert("修改失败！");
                }
                closeUpdateWarehouseDlg();
                $("#warehouse-table").bootstrapTable('refresh');
            }
        });
}

//添加，打开模态框
function openWarehouseDlg(){
    $("#addwarehousedlg").modal('show');
};

function closeAddWarehouseDlg() {
    $("#addwarehousedlg").modal('hide');
}

function closeUpdateWarehouseDlg() {
    $("#updatewarehousedlg").modal('hide');
}

function resetCondition() {
    $("#country").text(null);
    $("#fullName").text(null);
}

//添加转运仓
function saveWarehouse(){
            $.ajax({
                url:'/kite/warehouses/addWarehouse.action',
                type:'post',
                dataType:'json',
                data:$("#myform").serialize(),
                success:function(data){
                    if(data>0){
                        alert("添加成功！");
                    }else{
                        alert("添加失败！");
                    }
                    $("#warehouse-table").bootstrapTable('refresh');
                    closeAddWarehouseDlg();
                },
                error:function(){
                    alert("请求失败");
                }
            });

}


//条件查询
function getWarehouseByCon(){

    $("#warehouse-table").bootstrapTable('destroy');
    $('#warehouse-table').bootstrapTable({
        url: '/kite/warehouses/getWarehouses',         //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParamsType:"undefined",
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                pageNo: params.pageNumber,
                pageSize: params.pageSize,
                country:$("#country").val(),
                fullName:$("#fullName").val()
                // searchText: params.searchText
            };
            return param;
        },
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
        showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        columns: [{
            checkbox: true
        },{
            field: 'fullName',
            title: '转运仓全名'
        },{
            field: 'addressLine',
            title: '转运仓地址'
        },{
            field: 'country',
            title: '国家'
        },{
            field: 'province',
            title: '省/直辖市'
        },{
            field: 'city',
            title: '市/区'
        },{
            field: 'zip',
            title: '邮编'
        },{
            field: 'phoneNumber',
            title: '联系电话'
        },{
            field: 'operate',
            title: '操作',
            formatter: operateFormatter,
        }]
    });
}
