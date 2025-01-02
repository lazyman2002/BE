package impl;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.WishListController;
import proto.ServerClient;
import proto.WishListServiceGrpc;

public class WishListImpl extends WishListServiceGrpc.WishListServiceImplBase {
    @Override
    public void wishListCreate(ServerClient.WishListFullInfo request, StreamObserver<ServerClient.WishListFullInfo> responseObserver) {
        System.out.println("wishListCreate");

        try {
            WishListController wishListController = new WishListController();
            responseObserver.onNext(wishListController.wishListRegister(request));
            responseObserver.onCompleted();
        }
        catch (Exception e){
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void wishListUpdateInfo(ServerClient.WishListFullInfo request, StreamObserver<ServerClient.WishListFullInfo> responseObserver) {
        System.out.println("wishListUpdateInfo");

        try {
            WishListController wishListController = new WishListController();
            responseObserver.onNext(wishListController.wishListUpdate(request));
            responseObserver.onCompleted();
        }
        catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void wishListRead(ServerClient.UserMetaInfo request, StreamObserver<ServerClient.WishListFullInfo> responseObserver) {
        System.out.println("wishListRead");

        try {
            WishListController wishListController = new WishListController();
            responseObserver.onNext(wishListController.wishListRead(request));
            responseObserver.onCompleted();
        }
        catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }
}
