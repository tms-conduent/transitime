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
package org.transitime.api.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.transitime.ipc.data.IpcRoute;

/**
 * When have a list of routes.
 * @author Michael
 *
 */
@XmlRootElement
public class ApiRoutesDetails {
	@XmlElement(name = "routes")
	private List<ApiRouteDetails> routesData;

	/********************** Member Functions **************************/

	/**
	 * Need a no-arg constructor for Jersey. Otherwise get really obtuse
	 * "MessageBodyWriter not found for media type=application/json" exception.
	 */
	public ApiRoutesDetails() {
	}

	/**
	 * For constructing a ApiRoutes object from a Collection of IpcRoute
	 * objects. 
	 * 
	 * @param routes
	 */
	public ApiRoutesDetails(Collection<IpcRoute> routes) {
		routesData = new ArrayList<ApiRouteDetails>();
		for (IpcRoute route : routes) {
			routesData.add(new ApiRouteDetails(route));
		}
	}
}