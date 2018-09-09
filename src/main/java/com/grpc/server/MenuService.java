package com.grpc.server;

import com.googlecode.protobuf.format.JsonFormat;
import com.grpc.server.menu.*;
import com.grpc.server.util.CommonUtil;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import net.sf.json.JSONObject;


@GrpcService(MenuServiceGrpc.class)
public class MenuService extends MenuServiceGrpc.MenuServiceImplBase{

    @Override
    //获取自定义菜单配置接口
    public void configMenu(MenuRequest request, StreamObserver<MenuConfigResponse> responseObserver){
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
        //从protobuf转json
        //String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"GET",null);
        MenuConfigResponse menuConfigResponse=(MenuConfigResponse)JSONObject.toBean(result, MenuConfigResponse.class);
        responseObserver.onNext(menuConfigResponse);
        responseObserver.onCompleted();
    }

    @Override
    //自定义菜单创建接口
    public void createMenu(CreateMenuRequest request, StreamObserver<MenuResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        MenuResponse response=(MenuResponse)JSONObject.toBean(result, MenuResponse.class);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    //自定义菜单查询接口
    public void queryMenu(MenuRequest request, StreamObserver<QueryMenuResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
        //从protobuf转json
        //String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"GET",null);
        QueryMenuResponse queryMenuResponse=(QueryMenuResponse)JSONObject.toBean(result, QueryMenuResponse.class);
        responseObserver.onNext(queryMenuResponse);
        responseObserver.onCompleted();
    }

    @Override
    //自定义菜单删除接口
    public void deleteMenu(MenuRequest request, StreamObserver<MenuResponse> responseObserver) {

        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        //从protobuf转json
        //String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"GET",null);
        MenuResponse response=(MenuResponse)JSONObject.toBean(result, MenuResponse.class);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
