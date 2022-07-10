public  class BulderA {
     final Integer dailyPortions;
     final Integer servings;
     Integer fat = 0;
     Integer sugar = 0;
     Integer watter = 0;

    public BulderA(Integer dailyPortions, Integer servings) {
        this.dailyPortions = dailyPortions;
        this.servings = servings;
    }

    public BulderA fat(Integer fat) {
        this.fat = fat;
        return this;
    }

    public BulderA sugar(Integer sugar) {
        this.sugar = sugar;
        return this;
    }

    public BulderA watter(Integer watter) {
        this.watter = watter;
        return this;
    }

//    public FoodNutrients build() {
//        return new FoodNutrients(this);
//    }
}
