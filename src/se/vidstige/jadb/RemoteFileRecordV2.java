package se.vidstige.jadb;

/**
 * Returned from LIS2 command, similar to {@link RemoteFileRecord} but has longs instead of ints
 */
class RemoteFileRecordV2 extends RemoteFile {
    public static final RemoteFileRecordV2 DONE = new RemoteFileRecordV2(null, 0, 0, 0);

    private final long mode;
    private final long size;
    private final long lastModified;

    public RemoteFileRecordV2(String name, long mode, long size, long lastModified) {
        super(name);
        this.mode = mode;
        this.size = size;
        this.lastModified = lastModified;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public long getLastModified() {
        return lastModified;
    }

    @Override
    public boolean isDirectory() {
        return (mode & (1 << 14)) == (1 << 14);
    }
}
