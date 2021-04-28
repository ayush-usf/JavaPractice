package com.company.tree;

// A Tree consists of several branches (other small trees). Each branch and have one of bird houses.
// Each bird house can have one or more birds. The birds can be of any color. But, the black birds consumes more food
// than other color birds. Your task is to compute how much extra food would be required in total.

public class BirdTreeProblem {
    // OOD with recursion - Start at the lowest level
    // Could be possible that problem might repeat
    Tree root;

    static class Tree {
        BirdHouse house;
        Tree left;
        Tree right;

        public Tree(BirdHouse house) {
            this.house = house;
            this.left = null;
            this.right = null;
        }
    }

    static class BirdHouse{
        Bird bird;
        BirdHouse left;
        BirdHouse right;

        public BirdHouse(Bird bird) {
            this.bird = bird;
            this.left = null;
            this.right = null;
        }
    }
    static class Bird{
        String color;
        Bird left;
        Bird right;

        public Bird(String color) {
            this.color = color;
        }
    }

    // Start from bottom up
    static int computeExtraFoodCntBirds(Bird bird){
        if(bird == null) return 0;
        int count = bird.color.equals("black") ? 1 : 0;
        return computeExtraFoodCntBirds(bird.left) +
                computeExtraFoodCntBirds(bird.right) +
                count;
    }

    // Start from bottom up
    static int computeExtraFoodCntBirdHouse(BirdHouse house){
        if(house == null) return 0;
        return computeExtraFoodCntBirdHouse(house.left) +
                computeExtraFoodCntBirdHouse(house.right) +
                computeExtraFoodCntBirds(house.bird);
    }

    // get the black bird count
    static int computeExtraFoodCnt(Tree root){
        if(root == null) return 0;
        return computeExtraFoodCnt(root.left) +
                computeExtraFoodCnt(root.right) +
                computeExtraFoodCntBirdHouse(root.house);
    }

    public static void main(String[] args) {
        Bird bird1 = new Bird("black");
        Bird bird2 = new Bird("black");
        Bird bird3 = new Bird("black");
        bird1.left = bird2;
        bird1.right = bird3;

        BirdHouse house1 = new BirdHouse(bird1);

        Bird bird8 = new Bird("blue");
        Bird bird4 = new Bird("black");
        Bird bird5 = new Bird("black");
        Bird bird6 = new Bird("black");

        bird8.left = bird4;
        bird8.right = bird6;
        bird8.left.left = bird5;

        house1.left = new BirdHouse(bird8);

        house1.right = new BirdHouse(new Bird("black"));
        house1.left.left = new BirdHouse(new Bird("blue"));

        Tree tree1 = new Tree(house1);

        Bird bird7 = new Bird("black");

        bird7.left = new Bird("blue");
        bird7.right = new Bird("blue");
        bird7.left.left = new Bird("blue");
        bird7.left.right = new Bird("blue");

        BirdHouse house2 = new BirdHouse(bird7);

        Bird bird13 = new Bird("blue");
        bird13.left = new Bird("blue");
        bird13.right = new Bird("black");

        house2.left = new BirdHouse(bird13);

        house2.right = new BirdHouse(new Bird("black"));

        tree1.left = new Tree(house2);
        System.out.println(computeExtraFoodCnt(tree1));
    }
}
