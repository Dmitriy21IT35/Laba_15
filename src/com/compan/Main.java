package com.compan;

import static com.compan.Main.Sizes.*;

public class Main{
    public interface IFemaleClothes {
        void dressFemale();
    }
    public interface IMaleClothes {
        void dressMale();
    }
    public abstract static class Clothes {
        private final Sizes size;
        private final String color;
        private double cost;

        public Clothes(Sizes size, String color) {
            this.size = size;
            this.color = color;
        }

        public Clothes(Sizes size, String color, double cost) {
            this(size, color);
            this.cost = cost;
        }

        public Sizes getSize() {
            return size;
        }

        public String getColor() {
            return color;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Clothes)) return false;

            Clothes clothes = (Clothes) o;

            if (Double.compare(clothes.cost, cost) != 0) return false;
            if (size != clothes.size) return false;
            return color.equals(clothes.color);
        }

        public int hashCode() {
            int result;
            long temp;
            result = size.hashCode();
            temp = Double.doubleToLongBits(cost);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            result = 31 * result + color.hashCode();
            return result;
        }
    }
    public static class DressMakingStudio {
        public void dressMale(Clothes[] clothes) {
            System.out.println("Мужская одежда (в наличии):");
            for (Clothes clothe : clothes) {
                if (clothe instanceof IMaleClothes) {
                    System.out.println(clothe);
                }
            }
        }

        public void dressFemale(Clothes[] clothes) {
            System.out.println("Женская одежда (в наличии):");
            for (Clothes clothe : clothes) {
                if (clothe instanceof IFemaleClothes) {
                    System.out.println(clothe);
                }
            }
        }
    }
    public enum Sizes {
        XXS(36) {
            @Override
            public String getDescription() {
                return "детский размер";
            }
        },
        XS(38),
        S(40),
        M(42),
        L(44);

        Sizes(int euroSize) {
            EuroSize = euroSize;
        }

        public String getDescription() {
            return "взрослый размер";
        }

        public String toString() {
            return name() + "(" + EuroSize + ") " + getDescription();
        }

        private final int EuroSize;
    }
    public abstract static class Skirt extends Clothes implements IFemaleClothes {
        public Skirt(Sizes size, String color) {
            super(size, color);
        }

        public Skirt(Sizes size, String color, double cost) {
            super(size, color, cost);
        }

        public String toString() {
            return "Юбка{" +
                    "размер = " + getSize() +
                    ", цена = " + getCost() + " грн" +
                    ", цвет = " + getColor() +
                    "}";
        }
    }
    public abstract static class TeeShirt extends Clothes implements IMaleClothes, IFemaleClothes{
        public TeeShirt(Sizes size, String color) {
            super(size, color);
        }

        public TeeShirt(Sizes size, String color, double cost) {
            super(size, color, cost);
        }

        public String toString() {
            return "Футболка{" +
                    "размер = " + getSize() +
                    ", цена = " + getCost() + " грн" +
                    ", цвет = " + getColor() +
                    "}";
        }
    }
    public abstract static class Tie extends Clothes implements IMaleClothes{
        public Tie(Sizes size, String color) {
            super(size, color);
        }

        public Tie(Sizes size, String color, double cost) {
            super(size, color, cost);
        }

        @Override
        public String toString() {
            return "Галстук{" +
                    "размер = " + getSize () +
                    ", цена = " + getCost () + " грн" +
                    ", цвет = " + getColor () +
                   "}";
        }
    }
    public abstract static class Trousers extends Clothes implements IMaleClothes, IFemaleClothes{
        public Trousers(Sizes size, String color) {
            super(size, color);
        }

        public Trousers(Sizes size, String color, double cost) {
            super(size, color, cost);
        }

        public String toString() {
            return "Штаны{" +
                    "размер = " + getSize() +
                    ", цена = " + getCost() + " грн" +
                    ", цвет = " + getColor() +
                    "}";
        }
    }
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TeeShirt (XS, "темно-серый", 3500) {
                    @Override
                    public void dressMale() {
                    }
                    @Override
                    public void dressFemale() {
                    }
                },
                new TeeShirt (L, "черный", 2503) {
                    @Override
                    public void dressMale() {
                    }
                    @Override
                    public void dressFemale() {
                    }
                },
                new Trousers (M, "голубой", 5000) {
                    @Override
                    public void dressMale() {
                    }
                    @Override
                    public void dressFemale() {
                    }
                },
                new Trousers (XXS, "синий", 2300) {
                    @Override
                    public void dressMale() {
                    }

                    @Override
                    public void dressFemale() {
                    }
                },
                new Skirt (S, "розовый", 4400) {
                    @Override
                    public void dressFemale() {
                    }
                },
                new Skirt (M, "красный", 3900) {
                    @Override
                    public void dressFemale() {
                    }
                },
                new Tie (L, "синий", 2000) {
                    @Override
                    public void dressMale() {
                    }
                },
                new Tie (L, "красный", 12000) {
                    @Override
                    public void dressMale() {
                    }
                },
        };

        DressMakingStudio studio = new DressMakingStudio();
        studio.dressMale(clothes);
        System.out.println();
        studio.dressFemale(clothes);
    }
}
