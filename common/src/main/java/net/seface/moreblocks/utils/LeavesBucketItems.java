package net.seface.moreblocks.utils;

public enum LeavesBucketItems {
    LEAF_LITTER("leaf_litter", "leaves_bucket"),
    FROZEN_LEAF_LITTER("frozen_leaf_litter", "frozen_leaves_bucket"),
    PINK_PETALS_LITTER("pink_petals_litter", "pink_petals_bucket");

    private final String blockIdentifier;
    private final String bucketIdentifier;

    LeavesBucketItems(String blockIdentifier, String bucketIdentifier) {
        this.blockIdentifier = blockIdentifier;
        this.bucketIdentifier = bucketIdentifier;
    }

    public String getBlockIdentifier() {
        return this.blockIdentifier;
    }

    public String getBucketIdentifier() {
        return this.bucketIdentifier;
    }

    public static LeavesBucketItems getByBlockIdentifier(String blockIdentifier) {
        for (LeavesBucketItems value : LeavesBucketItems.values()) {
            if (value.blockIdentifier.equals(blockIdentifier)) {
                return value;
            }
        }

        return LeavesBucketItems.LEAF_LITTER;
    }
}
