/*
 * This file is part of Transitime.org
 * 
 * Transitime.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPL) as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * Transitime.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Transitime.org .  If not, see <http://www.gnu.org/licenses/>.
 */

package org.transitime.ipc.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import org.transitime.db.structs.Location;
import org.transitime.db.structs.Stop;
import org.transitime.ipc.data.IpcActiveBlock;
import org.transitime.ipc.data.IpcCompleteVehicle;
import org.transitime.ipc.data.IpcGtfsRealtimeVehicle;
import org.transitime.ipc.data.IpcVehicle;
import org.transitime.ipc.data.IpcVehicleConfig;

/**
 * Defines the RMI interface used for obtaining vehicle information.
 * 
 * @author SkiBu Smith
 * 
 */
public interface VehiclesInterface extends Remote {

	/**
	 * For getting configuration information for all vehicles. Useful for
	 * determining IDs of all vehicles in system
	 * 
	 * @return Collection of IpcVehicleConfig objects
	 * @throws RemoteException
	 */
	public Collection<IpcVehicleConfig> getVehicleConfigs() 
			throws RemoteException;
	
	/**
	 * Gets from server IpcVehicle info for all vehicles.
	 * 
	 * @return Collection of IpcVehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcVehicle> get() throws RemoteException;

	/**
	 * Gets from server IpcCompleteVehicle info for all vehicles.
	 * 
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcCompleteVehicle> getComplete() throws RemoteException;

	/**
	 * Gets from server IpcCompleteVehicle info for all vehicles.
	 * 
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcGtfsRealtimeVehicle> getGtfsRealtime()
			throws RemoteException;

	/**
	 * Gets from server IpcVehicle info for specified vehicle.
	 * 
	 * @param vehicleId
	 *            ID of vehicle to get data for
	 * @return info for specified vehicle
	 * @throws RemoteException
	 */
	public IpcVehicle get(String vehicleId) throws RemoteException;

	/**
	 * Gets from server IpcCompleteVehicle info for specified vehicle.
	 * 
	 * @param vehicleId
	 *            ID of vehicle to get data for
	 * @return info for specified vehicle
	 * @throws RemoteException
	 */
	public IpcCompleteVehicle getComplete(String vehicleId)
			throws RemoteException;

	/**
	 * Gets from server IpcVehicle info for vehicles specified by vehicles
	 * parameter.
	 * 
	 * @param vehicleIds
	 *            Collection of vehicle IDs to get Vehicle data for.
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcVehicle> get(Collection<String> vehicleIds)
			throws RemoteException;

	/**
	 * Gets from server IpcCompleteVehicle info for vehicles specified by
	 * vehicles parameter.
	 * 
	 * @param vehicleIds
	 *            Collection of vehicle IDs to get Vehicle data for.
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcCompleteVehicle> getComplete(
			Collection<String> vehicleIds) throws RemoteException;

	/**
	 * Gets from server IpcVehicle info for all vehicles currently. associated
	 * with route.
	 * 
	 * @param routeIdOrShortName
	 *            Specifies which route to get Vehicle data for
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcVehicle> getForRoute(String routeIdOrShortName)
			throws RemoteException;

	/**
	 * Gets from server IpcCompleteVehicle info for all vehicles currently.
	 * associated with route.
	 * 
	 * @param routeIdOrShortName
	 *            Specifies which route to get Vehicle data for
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcCompleteVehicle> getCompleteForRoute(
			String routeIdOrShortName) throws RemoteException;

	/**
	 * Gets from server IpcVehicle info for all vehicles currently. associated
	 * with route.
	 * 
	 * @param routeIdsOrShortNames
	 *            Specifies which routes to get Vehicle data for
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcVehicle> getForRoute(
			Collection<String> routeIdsOrShortNames) throws RemoteException;

	/**
	 * Gets from server IpcCompleteVehicle info for all vehicles currently.
	 * associated with route.
	 * 
	 * @param routeIdsOrShortNames
	 *            Specifies which routes to get Vehicle data for
	 * @return Collection of Vehicle objects
	 * @throws RemoteException
	 */
	public Collection<IpcCompleteVehicle> getCompleteForRoute(
			Collection<String> routeIdsOrShortNames) throws RemoteException;

	/**
	 * Gets from the server IpcActiveBlocks for blocks that are currently
	 * active.
	 * 
	 * @param routeIds
	 *            List of routes that want data for. Can also be null or empty.
	 * @param allowableBeforeTimeSecs
	 *            How much before the block time the block is considered to be
	 *            active
	 * @return Collection of blocks that are active
	 * @throws RemoteException
	 */
	public Collection<IpcActiveBlock> getActiveBlocks(
			Collection<String> routeIds, int allowableBeforeTimeSecs) 
					throws RemoteException;
	
	/**
	 * Get the estimated location of a vehicle at a point in time in the past.
	 * @param vehicleId
	 * 			The vechicleId of the vehicles whos location at a point in time we are looking for.
	 * @param time T
	 * 			The time as which we are looking for the vechicle estimate
	 * @return The estimate location of the vechicle
	 * @throws RemoteException
	 */
	public Location getVechicleLocation(String vehicleId, long time) throws RemoteException;
	
	/**
	 * Get the last stop the bus was closest to at a point in time. 
	 * @param vechileId 
	 * 			The vechicle who we are looking at.
	 * @param time 
	 * 			The time we want to find the nearest stop for.
	 * @return The closest departure stop that has been arrived at or passed on the vehicles current trip at the point in time.
	 * @throws RemoteException
	 */
	public Stop getLastStopOnRoute(String vehicleId, long time) throws RemoteException;
}