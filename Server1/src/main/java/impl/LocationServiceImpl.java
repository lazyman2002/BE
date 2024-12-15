package impl;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.controller.Converter;
import org.controller.LocationController;
import org.model.Locations;
import proto.LocationServiceGrpc;
import proto.ServerClient;

import java.util.ArrayList;

public class LocationServiceImpl extends LocationServiceGrpc.LocationServiceImplBase {

    @Override
    public void locationListRead(Empty request, StreamObserver<ServerClient.LocationFullInfo> responseObserver) {
        System.out.println("locationListRead");

        LocationController locationController = new LocationController();
        try {
            ArrayList<Locations> locations = locationController.locationList();
            System.out.println(locations);
            for (Locations location : locations) {
                ServerClient.LocationFullInfo locationFullInfo = Converter.locationsToFullProto(location);
                responseObserver.onNext(locationFullInfo);
            }
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void locationReadInfo(ServerClient.LocationMetaInfo request, StreamObserver<ServerClient.LocationFullInfo> responseObserver) {
        System.out.println("locationReadInfo");

        try {
            LocationController locationController = new LocationController();
            Locations location = locationController.locationRead(request);
            responseObserver.onNext(Converter.locationsToFullProto(location));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void locationUpdateInfo(ServerClient.LocationFullInfo request, StreamObserver<ServerClient.LocationFullInfo> responseObserver) {
        System.out.println("locationUpdateInfo");

        try {
            LocationController locationController = new LocationController();
            Locations location = locationController.locationUpdate(request);
            responseObserver.onNext(Converter.locationsToFullProto(location));
            responseObserver.onCompleted();
        } catch (Exception sqlEx) {
            StatusRuntimeException dbError = Status.NOT_FOUND
                    .withDescription(sqlEx.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void locationRegister(ServerClient.LocationFullInfo request, StreamObserver<ServerClient.LocationFullInfo> responseObserver) {
        System.out.println("locationRegister");

        try {
            LocationController locationController = new LocationController();
            Locations location = locationController.locationRegister(request);
            responseObserver.onNext(Converter.locationsToFullProto(location));
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

    @Override
    public void locationDelete(ServerClient.LocationMetaInfo request, StreamObserver<BoolValue> responseObserver) {
        System.out.println("locationDeleteInfo");

        try {
            LocationController locationController = new LocationController();
            Boolean bool = locationController.locationDelete(request);
            responseObserver.onNext(BoolValue.newBuilder().setValue(bool).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            StatusRuntimeException dbError = Status.ALREADY_EXISTS
                    .withDescription(e.getMessage())
                    .asRuntimeException();
            responseObserver.onError(dbError);
        }
    }

}
