public class FoodNutrients {
    private Integer dailyPortions;
    private  Integer servings;
    private  Integer fat;
    private  Integer sugar;
    private  Integer watter;

    public static class Builder {
        final Integer dailyPortions;
        final Integer servings;
        Integer fat = 0;
        Integer sugar = 0;
        Integer watter = 0;

        public Builder(Integer dailyPortions, Integer servings) {
            this.dailyPortions = dailyPortions;
            this.servings = servings;
        }

        public Builder fat(Integer fat) {
            this.fat = fat;
            return this;
        }

        public Builder sugar(Integer sugar) {
            this.sugar = sugar;
            return this;
        }

        public Builder watter(Integer watter) {
            this.watter = watter;
            return this;
        }

        public FoodNutrients build() {
            return new FoodNutrients(this);
        }
    }

    public FoodNutrients (Builder bulderA) {
       this.dailyPortions = bulderA.dailyPortions;
       this.servings = bulderA.servings;
       this.fat = bulderA.fat;
       this.sugar = bulderA.sugar;
       this.watter = bulderA.watter;
    }

    @Override
    public String toString() {
        return "FoodNutrients{" +
                "dailyPortions=" + dailyPortions +
                ", servings=" + servings +
                ", fat=" + fat +
                ", sugar=" + sugar +
                ", watter=" + watter +
                '}';
    }
}
