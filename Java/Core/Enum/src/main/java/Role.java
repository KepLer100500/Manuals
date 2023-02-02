public enum Role {
    USER(true, false),
    ADMIN(true, true);

    private final boolean canRead;
    private final boolean canWrite;
    Role(boolean canRead, boolean canWrite) {
        this.canRead = canRead;
        this.canWrite = canWrite;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public boolean isCanWrite() {
        return canWrite;
    }
}
