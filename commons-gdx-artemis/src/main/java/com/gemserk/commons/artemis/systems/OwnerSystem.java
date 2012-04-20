package com.gemserk.commons.artemis.systems;

import com.artemis.Entity;
import com.artemis.EntityProcessingSystem;
import com.gemserk.commons.artemis.components.ContainerComponent;
import com.gemserk.commons.artemis.components.OwnerComponent;

public class OwnerSystem extends EntityProcessingSystem {

	@SuppressWarnings("unchecked")
	public OwnerSystem() {
		super(OwnerComponent.class);
	}

	@Override
	protected void enabled(Entity e) {
		OwnerComponent ownerComponent = OwnerComponent.get(e);
		if (ownerComponent.getOwner() == null)
			return;
		ContainerComponent containerComponent = ContainerComponent.get(ownerComponent.getOwner());
		if (containerComponent == null)
			return;
		containerComponent.getChildren().add(e);
	}

	@Override
	protected void disabled(Entity e) {
		OwnerComponent ownerComponent = OwnerComponent.get(e);
		if (ownerComponent.getOwner() == null)
			return;
		ContainerComponent containerComponent = ContainerComponent.get(ownerComponent.getOwner());
		if (containerComponent == null)
			return;
		containerComponent.getChildren().remove(e);
	}

	@Override
	protected void process(Entity e) {

	}

}