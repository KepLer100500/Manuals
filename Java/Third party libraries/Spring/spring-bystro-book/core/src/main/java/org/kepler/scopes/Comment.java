package org.kepler.scopes;

import lombok.Data;
import lombok.NonNull;

@Data
class Comment {
    @NonNull
    private String author;
    @NonNull
    private String text;
}
