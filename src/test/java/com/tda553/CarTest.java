package com.tda553;

import org.junit.Before;
import org.junit.Test;

import com.tda553.Models.Vehicle;
import com.tda553.VehicleTypes.Cars.Saab95;
import com.tda553.VehicleTypes.Cars.Volvo240;

import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;

public class CarTest
{

    private static List<Vehicle> cars = new ArrayList<>();

    @Before
    public void setUp()
    {
        cars.add(new Volvo240());
        cars.add(new Saab95());
    }

    @Test( expected = AssertionError.class)
    public void MoveCars()
    {
        int[] start_position = {0, 0};

        for (Vehicle car : cars)
        {
            System.out.println(car.toString());
            assertArrayEquals(start_position, car.getPosition());

            car.startEngine();

            car.gas(1);
            car.move();
            // Has the car moved?
            assertArrayEquals(car.getPosition(), new int[] {1, 0});

            car.brake(1);
            car.move();
            
            // Has the car stopped?
            assertArrayEquals(car.getPosition(), new int[] {1, 0});

            // Start the car again, try turning left.
            car.startEngine();
            car.turnLeft();
            car.gas(1);
            car.move();
            assertArrayEquals(car.getPosition(), new int[] {1, 1});

            // Turn right...
            car.turnRight();
            car.move();
            assertArrayEquals(car.getPosition(), new int[] {2, 1});
        }
    }
}
