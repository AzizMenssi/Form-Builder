import java.rmi.Remote;
import java.rmi.RemoteException;


public interface MyService extends Remote {
	void setMsg(Note m)throws RemoteException;
	Note getMsg()throws RemoteException;
	String getAllMsg() throws RemoteException;
}
