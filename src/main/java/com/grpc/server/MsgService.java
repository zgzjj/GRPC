package com.grpc.server;

import com.googlecode.protobuf.format.JsonFormat;
import com.grpc.server.msg.*;
import com.grpc.server.util.CommonUtil;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import net.sf.json.JSONObject;

@GrpcService(MsgServiceGrpc.class)
public class MsgService extends MsgServiceGrpc.MsgServiceImplBase{
    @Override
    //获取模板列表
    public void queryMsgTemp(MsgRequest request, StreamObserver<QueryMsgResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
        //从protobuf转json
        //String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"GET",null);
        QueryMsgResponse queryMsgResponse=(QueryMsgResponse)JSONObject.toBean(result, QueryMsgResponse.class);
        responseObserver.onNext(queryMsgResponse);
        responseObserver.onCompleted();
    }

    @Override
    //删除模板
    public void deleteMsgTemp(DeleteMsgRequest request, StreamObserver<MsgResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        MsgResponse msgResponse=(MsgResponse)JSONObject.toBean(result, MsgResponse.class);
        responseObserver.onNext(msgResponse);
        responseObserver.onCompleted();
    }

    @Override
    //发送模板消息
    public void sendMsgTemp(SendMsgRequest request, StreamObserver<SendMsgResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        SendMsgResponse sendMsgResponse=(SendMsgResponse)JSONObject.toBean(result, SendMsgResponse.class);
        responseObserver.onNext(sendMsgResponse);
        responseObserver.onCompleted();
    }

    @Override
    //客服接口-发消息
    public void customSendMsg(CustMsgRequest request, StreamObserver<MsgResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        MsgResponse msgResponse=(MsgResponse)JSONObject.toBean(result, MsgResponse.class);
        responseObserver.onNext(msgResponse);
        responseObserver.onCompleted();
    }

    @Override
    //上传图文消息内的图片获取URL(需要上传图片，用FORM表单方式上传一个图片)
    public void uploadImg(MsgRequest request, StreamObserver<UploadImgResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
        //从protobuf转json
        //String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",null);
        UploadImgResponse uploadImgResponse=(UploadImgResponse)JSONObject.toBean(result, UploadImgResponse.class);
        responseObserver.onNext(uploadImgResponse);
        responseObserver.onCompleted();
    }

    @Override
    //上传图文消息素材
    public void uploadNews(UploadNewsRequest request, StreamObserver<UploadNewsResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        UploadNewsResponse uploadNewsResponse=(UploadNewsResponse)JSONObject.toBean(result, UploadNewsResponse.class);
        responseObserver.onNext(uploadNewsResponse);
        responseObserver.onCompleted();
    }

    @Override
    //根据标签进行群发
    public void sendallMsg(SendAllMsgRequest request, StreamObserver<SendAllMsgResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        SendAllMsgResponse sendAllMsgResponse=(SendAllMsgResponse)JSONObject.toBean(result, SendAllMsgResponse.class);
        responseObserver.onNext(sendAllMsgResponse);
        responseObserver.onCompleted();
    }

    @Override
    //根据OpenID列表群发
    public void sendMsgByOpenID(SendMsgByOpenIDRequest request, StreamObserver<SendAllMsgResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        SendAllMsgResponse sendAllMsgResponse=(SendAllMsgResponse)JSONObject.toBean(result, SendAllMsgResponse.class);
        responseObserver.onNext(sendAllMsgResponse);
        responseObserver.onCompleted();
    }

    @Override
    //查询群发消息发送状态
    public void querySendAllStatus(SendStatusRequest request, StreamObserver<SendStatusResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        SendStatusResponse sendStatusResponse=(SendStatusResponse)JSONObject.toBean(result, SendStatusResponse.class);
        responseObserver.onNext(sendStatusResponse);
        responseObserver.onCompleted();
    }

    @Override
    //获取公众号的自动回复规则
    public void queryAutoreplyInfo(MsgRequest request, StreamObserver<AutoreplyInfoResponse> responseObserver) {
        //需要取得ACCESS_TOKEN
        String url="https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN";
        //从protobuf转json
        String param =JsonFormat.printToString(request);
        //通过api
        JSONObject result=CommonUtil.httpsRequest(url,"POST",param);
        AutoreplyInfoResponse autoreplyInfoResponse=(AutoreplyInfoResponse)JSONObject.toBean(result, AutoreplyInfoResponse.class);
        responseObserver.onNext(autoreplyInfoResponse);
        responseObserver.onCompleted();
    }
}
