package org.bowlerframework.squeryl.dao

import org.bowlerframework.squeryl.SquerylDao
import org.squeryl.{Table, KeyedEntity}
import org.squeryl.PrimitiveTypeMode._

/**
 * Created by IntelliJ IDEA.
 * User: wfaler
 * Date: 30/01/2011
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */

class LongKeyedDao[T <: KeyedEntity[Long]](theTable: Table[T])(implicit m : scala.Predef.Manifest[T]) extends SquerylDao[T, Long](theTable){
  def findById(id: Long): Option[T] = {
    try{
      Some(table.where(f => f.id === id).single)
    }catch{
      case e: Exception => return None
    }
  }

  override def create(entity: T) = {
	com.recursivity.commons.bean.BeanUtils.setProperty(entity.getClass, entity, "id", 0l)
	super.create(entity)	
  }

  override def findAll(offset: Int = 0, results: Int = Integer.MAX_VALUE) = from(table)(a => select(a) orderBy(a.id asc)).page(offset, results).toList
}