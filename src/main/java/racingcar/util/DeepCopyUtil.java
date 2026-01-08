package racingcar.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCopyUtil {

    private DeepCopyUtil() {
    }

    public static <T> T deepCopy(T obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Serializable)) {
            throw new IllegalArgumentException("[ERROR] 직렬화 가능한 객체만 깊은 복사가 가능합니다.");
        }
        try {
            byte[] bytes = serialize((Serializable) obj);
            return deserialize(bytes);
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("[ERROR] 깊은 복사 중 오류가 발생했습니다.");
        }
    }

    private static byte[] serialize(Serializable obj) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            oos.flush();
            return bos.toByteArray();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (T) ois.readObject();
        }
    }
}
