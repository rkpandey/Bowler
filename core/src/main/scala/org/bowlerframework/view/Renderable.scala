package org.bowlerframework.view

import org.bowlerframework.{Response, RequestScope, Request}

/**
 * Created by IntelliJ IDEA.
 * User: wfaler
 * Date: 28/12/2010
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */

trait Renderable{
  def render(models: Any*):Unit = render(RequestScope.request,RequestScope.response, models)

  def render(request: Request, response: Response, models: Any*): Unit = {

  }
}