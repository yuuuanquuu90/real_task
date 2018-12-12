package yuanqu.expressShipping.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import yuanqu.data.Route;

public interface IExpressServices extends Remote {
	public Route getRoute(String request) throws RemoteException;
}
