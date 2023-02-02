public enum Operation {
    SUM {
        @Override
        public int action(int a, int b) {
            return a + b;
        }
    },
    SUB {
        @Override
        public int action(int a, int b) {
            return a - b;
        }
    },
    MUL {
        @Override
        public int action(int a, int b) {
            return a * b;
        }
    },
    DIV {
        @Override
        public int action(int a, int b) {
            return a / b;
        }
    };

    public abstract int action(int a, int b);
}
