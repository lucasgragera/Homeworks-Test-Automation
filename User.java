public class User {
    int id;
    String phoneNumber;
    int age;
//constructor
    public User(int id, String phoneNumber, int age) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public void printUserInfo() {
        System.out.println("ID: " + id);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Age: " + age);
        System.out.println("--------------------");
    }

    public static void quickSort(User[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(User[] arr, int low, int high) {
        int pivot = arr[high].id;
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].id < pivot) {
                i++;

                User temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        User temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Sample usage
        User[] users = {
                new User(3, "351-5325248", 22),
                new User(1, "351-3962419", 52),
                new User(2, "351-6428406", 35)
        };

        System.out.println("Before Sorting:");
        for (User user : users) {
            user.printUserInfo();
        }

        // Sorting using Quicksort
        quickSort(users, 0, users.length - 1);

        System.out.println("After Sorting:");
        for (User user : users) {
            user.printUserInfo();
        }
    }
}