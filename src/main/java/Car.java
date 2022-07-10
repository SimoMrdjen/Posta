public class Car implements Vehicle{
    @Override
    public void printMaxSpeed() {
        System.out.println("Max speed for car is 16 km/h");
    }

    @Override
    public void printNeededLicense() {
        System.out.println("You need B license for drivingg car");
    }
}
