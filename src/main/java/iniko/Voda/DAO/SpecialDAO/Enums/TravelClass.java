package iniko.Voda.DAO.SpecialDAO.Enums;

public enum TravelClass {
    Economy {
        @Override
        public String toString() {
            return "Economy class";
        }
    },

    Business{
        @Override
        public String toString() {
            return "Business class";
        }
    },
    First{
        @Override
        public String toString() {
            return "First class";
        }
    },

}
