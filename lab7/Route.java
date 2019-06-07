package lab7;

public class Route {
        public String name;
        public String depTime;

        public Route(String name, String depTime) {
            this.name = name;
            this.depTime = depTime;
        }

        public Route() {
            name = null;
            depTime = null;
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getDepartureTime() {
            return depTime;
        }

    }
