package com.saurav.diceroller;

public class Die {
    // Defining class attributes with their proper data types
    private String type;
    private byte sides;
    private byte currentSideUp;

//    // A 0 argument constructor
//    public Die(){
//        this.type = "d6";
//        this.sides = 6;
//        this.currentSideUp = roll(sides);
//    }

    // A 1 argument constructor with dice sides as its parameter
    public Die(byte sides){
        this.type = "d"+sides;
        this.sides = sides;
        this.currentSideUp = roll();
    }

    // A setter method to set the type of a die object
    public void setType(String setType){
        this.type = setType;
    }

    // A setter method to set the sides of a die object with an upper limit of 120 (highest no. of sides for any die in the world)
    public void setSides(byte setSides){
        if(setSides <= 120){
            this.sides = setSides;
        }
    }

    // A setter method to set the current up side of a die object with an upper limit of 120 (highest no. of sides for any die in the world)
    public void setCurrentSideUp(byte setCurrentSideUp){
        if(setCurrentSideUp <= 120){
            this.currentSideUp = setCurrentSideUp;
        }
    }

    // A get method to get the type of an object
    public String getType(){
        return type;
    }

    // A get method to get the no. of sides of an object
    public byte getSides(){
        return sides;
    }

    // A get method to get the current up side value of an object
    public byte getCurrentSideUp(){
        return currentSideUp;
    }

    /*
    A public static roll method with no. of sides of any die object as its parameter. It generates a random no. for the die object within the specified range(from 1 to no. of sides in a given die). It can be called or invoked directly, without the need to initialize it first.
    */
    public byte roll(){
        // logic to generate a random value
        currentSideUp = (byte)(Math.ceil(Math.random()*this.sides));
        return currentSideUp;
    }
}
