
package io.helidon.examples.microstream.repository;

/*-
 * #%L
 * microstream-examples-helidon-mp
 * %%
 * Copyright (C) 2019 - 2022 MicroStream Software
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */

import io.helidon.examples.microstream.model.Product;
import io.helidon.examples.microstream.storage.configuration.StorageManager;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import one.microstream.integrations.cdi.types.Store;


@ApplicationScoped
public class ProductRepositoryStorage implements ProductRepository
{
	private static final Logger LOGGER = Logger.getLogger(ProductRepositoryStorage.class.getName());
	
	@Inject
	private StorageManager   storage;
	
	@Override
	public Collection<Product> getAll()
	{
		return this.storage.getProducts();
	}
	
	@Override
	@Store
	public Product save(final Product item)
	{
		this.storage.add(item);
		return item;
	}
	@Override
	@Store
	public Product update(final Product item)
	{
		this.storage.add(item);
		return item;
	}
	
	@Override
	public Optional<Product> findById(final long id)
	{
		LOGGER.info("Finding the item by id: " + id);
		return this.storage.findById(id);
	}
	
	@Override
	@Store
	public void deleteById(final long id)
	{
		this.storage.deleteById(id);
	}
}
