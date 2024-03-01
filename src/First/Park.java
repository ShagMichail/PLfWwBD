package First;

public class Park {
    public static class Attraction {
        private String name;
        private String operatingHours;
        private double cost;

        public Attraction(String name, String operatingHours, double cost) {
            this.name = name;
            this.operatingHours = operatingHours;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public double getCost() {
            return cost;
        }

        public String getOperatingHours() {
            return operatingHours;
        }
    }

    private Attraction[] attractions;

    public Park(Attraction[] attractions) {
        this.attractions = attractions;
    }

    public int getAttractionCount() {
        return attractions.length;
    }

    // Method to get an attraction by index
    public Attraction getAttraction(int index) {
        return attractions[index];
    }
}
