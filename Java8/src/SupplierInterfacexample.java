import java.util.UUID;
import java.util.function.Supplier;

public class SupplierInterfacexample {

    public static void main(String[] args) {
        Supplier<Integer> s = () -> 10;
        Supplier<UUID> uuid=()-> UUID.randomUUID();

        System.out.println(uuid.get());
        System.out.println(s.get());
    }
}
