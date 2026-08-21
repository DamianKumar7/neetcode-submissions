interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    // Write your code here
    @Override
    Vehicle createVehicle(){
        Vehicle car = new Car();
        return car;
    }
}

class BikeFactory extends VehicleFactory {
    // Write your code here
    @Override
    Vehicle createVehicle(){
        Vehicle bike = new Bike();
        return bike;
    }
}

class TruckFactory extends VehicleFactory {
    // Write your code here
    @Override
    Vehicle createVehicle(){
        Vehicle truck = new Truck();
        return truck;
    }
}
