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
        $('#commodity-table').bootstrapTable({
            url: '/kite/commodity/getCommodities',         //请求后台的URL（*）
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
                field: 'kind',
                title: '类别'
            },{
                field: 'brand',
                title: '品牌'
            },{
                field: 'name',
                title: '商品名称'
            },{
                field: 'size',
                title: '商品尺寸大小'
            },{
                field: 'count',
                title: '数量'
            },{
                field: 'merchantLogisticsNo',
                title: '商家物流单号'
            },{
                field: 'unitPrice',
                title: '单价'
            },{
                field: 'totalPrice',
                title: '总价'
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

function delManyCommodities(){
    var idstr=[];
    //获取选中的行
    var a= $('#commodity-table').bootstrapTable('getSelections');
    if(a.length>0){
        if(confirm("您确定要删除选中的数据吗？")){
            $.each(a,function(index){
                idstr.push(a[index].id);
            });
            $.ajax({
                url:'/kite/commodity/delCommodities.action',
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
                    $('#commodity-table').bootstrapTable('refresh');
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
        '<button type="button" class=" btn btn-info" onclick="getCommodityValue(' + row.id + ')">修改</button>',
        '&nbsp;&nbsp;&nbsp;<button class=" btn btn-danger" type="button" onclick="delCommodity(' + row.id + ')">删除</button>'
    ].join('');
}

//修改前，打开模态框
function getCommodityValue(id){
    $.ajax({
        url:'commodity/getCommodityById.action',
        dataType:'json',
        type:'post',
        data:{
            id:id
        },
        success:function(data){
            $("#commodity_id").val(data.id);
            $("#commodity_kind1").val(data.kind);
            $("#commodity_brand1").val(data.brand);
            $("#commodity_name1").val(data.name);
            $("#commodity_count1").val(data.count);
            $("#merchant_logistics_no1").val(data.merchantLogisticsNo);
            $("#commodity_unit_price1").val(data.unitPrice);
            $("#commodity_total_price1").val(data.totalPrice);
            $("#commodity_size1").val(data.size);
            $("#updatecommoditydlg").modal('show');
        },
        error:function(){
            alert('请求失败！');
        }
    });
}

    //删除商品信息
function delCommodity(id){
        if(confirm("您确定要删除这条数据吗?")){
            $.ajax({
                url:'/kite/commodity/delCommodity.action',
                dataType:'json',
                type:'post',
                data:{uid:id},
                success:function(data){
                    if(data>0){
                        alert("删除成功！");
                    }else{
                        alert("删除失败！");
                    }
                    $("#commodity-table").bootstrapTable('refresh');
                },
                error:function(){
                    alert("请求失败！");
                }
            });
        }
    }

//修改商品信息
function updateCommodity(){
        $.ajax({
            url:'/kite/commodity/updateCommodity.action',
            dataType:'json',
            type:'post',
            data:$("#myform1").serialize(),
            success:function(data){
                if(data>0){
                    alert("修改成功！");
                }else{
                    alert("修改失败！");
                }
                closeUpdatePackageInfoDlg();
                $("#commodity-table").bootstrapTable('refresh');
            }
        });

}

//添加，打开模态框
function openCommodityDlg(){
    $("#addcommoditydlg").modal('show');
};

function closeAddCommodityDlg() {
    $("#addcommoditydlg").modal('hide');
}

function closeUpdatePackageInfoDlg() {
    $("#updatecommoditydlg").modal('hide');
}

function resetCondition() {
    $("#kind").text(null);
    $("#brand").text(null);
    $("#name").text(null);
    $("#merchantLogisticsNo").text(null);
}

//添加商品
function saveCommodity(){
            $.ajax({
                url:'/kite/commodity/addCommodity.action',
                type:'post',
                dataType:'json',
                data:$("#myform").serialize(),
                success:function(data){
                    if(data>0){
                        alert("添加成功！");
                    }else{
                        alert("添加失败！");
                    }
                    $("#commodity-table").bootstrapTable('refresh');
                    closeAddCommodityDlg();
                },
                error:function(){
                    alert("请求失败");
                }
            });

}


//条件查询
function getCommodityByCon(){

    $("#commodity-table").bootstrapTable('destroy');
    $('#commodity-table').bootstrapTable({
        url: '/kite/commodity/getCommodities',         //请求后台的URL（*）
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
                kind:$("#kind").val(),
                brand:$("#brand").val(),
                name:$("#name").val(),
                merchantLogisticsNo:$("#merchantLogisticsNo").val()
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
            field: 'id',
            title: '序号'
        },{
            field: 'kind',
            title: '类别'
        },{
            field: 'brand',
            title: '品牌'
        },{
            field: 'name',
            title: '商品名称'
        },{
            field: 'size',
            title: '商品尺寸大小'
        },{
            field: 'count',
            title: '数量'
        },{
            field: 'merchantLogisticsNo',
            title: '商家物流单号'
        },{
            field: 'unitPrice',
            title: '单价'
        },{
            field: 'totalPrice',
            title: '总价'
        },{
            field: 'operate',
            title: '操作',
            formatter: operateFormatter,
        }]
    });
}
