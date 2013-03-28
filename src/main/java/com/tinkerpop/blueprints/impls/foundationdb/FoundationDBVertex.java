package com.tinkerpop.blueprints.impls.foundationdb;

import java.util.Set;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.VertexQuery;
import com.foundationdb.tuple.Tuple;
import com.foundationdb.Database;
import com.foundationdb.Transaction;

public class FoundationDBVertex extends FoundationDBElement implements Vertex {
	
	Database db;

	public FoundationDBVertex(Database db, Object vID) {
		super();
		if (vID != null) this.id = vID;
		this.db = db;
	}
	
	public FoundationDBVertex(Database db) {
		super();
		this.db = db;
	}

	@Override
	public Object getId() {
		return this.id;
	}

	@Override
	public <T> T getProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getPropertyKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T removeProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Edge addEdge(String arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Edge> getEdges(Direction arg0, String... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Vertex> getVertices(Direction arg0, String... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VertexQuery query() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean exists() {
		Transaction tr = db.createTransaction();
//		return tr.get(new Tuple().add("/v/").add(this.id.toString()).pack()).get() != null;
		return tr.get(this.getId().toString().getBytes()).get() != null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoundationDBVertex other = (FoundationDBVertex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}