package family_tree.writer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface Writable extends Serializable {
    void save(Serializable serializable, String filePath);
    Object read(String filePath);

}
