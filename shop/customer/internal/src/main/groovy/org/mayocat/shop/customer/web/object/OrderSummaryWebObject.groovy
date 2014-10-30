/**
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.shop.customer.web.object

import groovy.transform.CompileStatic
import org.mayocat.rest.api.object.DateWebObject
import org.mayocat.shop.billing.model.Order
import org.mayocat.shop.catalog.web.object.PriceWebObject

/**
 * @version $Id$
 */
@CompileStatic
class OrderSummaryWebObject
{
    String slug

    String status

    PriceWebObject grandTotal

    PriceWebObject itemsTotal

    PriceWebObject shipping

    DateWebObject date

    Integer numberOfItems

    def withOrder(Order order, Locale locale)
    {
        this.slug = order.slug
        this.grandTotal = new PriceWebObject().withPrice(order.grandTotal, order.currency, locale)
        this.itemsTotal = new PriceWebObject().withPrice(order.itemsTotal, order.currency, locale)
        this.shipping = new PriceWebObject().withPrice(order.shipping, order.currency, locale)
        this.date = new DateWebObject().withDate(order.creationDate, locale)
        this.numberOfItems = (order.orderData.get("items") as List).size()
        this.status = order.status.toString().toLowerCase()
    }
}