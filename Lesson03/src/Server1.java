import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server1 {
    public static final int PORT = 8082;
    private AuthService authService;
    private Set<ClientHandler> clientHandlers;

    public Server1() {
        this(PORT);
    }

    public Server1(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            authService = new DBAuthService();
            System.out.println("Auth is started up");

            clientHandlers = new HashSet<>();

            while (true) {
                System.out.println("Waiting for a connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isOccupied(AuthService.Record record) {
        for (ClientHandler ch : clientHandlers) {
            if (ch.getRecord().equals(record)) {
                return true;
            }
        }
        return false;
    }

    public synchronized Set<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }

    public synchronized void subscribe(ClientHandler ch) {
        clientHandlers.add(ch);
    }

    public synchronized void unsubscribe(ClientHandler ch) {
        clientHandlers.remove(ch);
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler ch : clientHandlers) {
            ch.sendMessage(message);
        }
    }

    public synchronized boolean sendDirectMessage(String nick, String message) {
        for (ClientHandler ch : clientHandlers) {
            if ( nick.equalsIgnoreCase(ch.getRecord().getName())) {
                ch.sendMessage(message);
                return true;
            }
        }
        return false;
    }
}