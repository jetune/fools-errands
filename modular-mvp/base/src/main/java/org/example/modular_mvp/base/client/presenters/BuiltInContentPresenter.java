/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details. 
 * You should have received a copy of the GNU Lesser General Public License, 
 * v.2.1 along with this distribution; if not, write to the Free Software 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */
package org.example.modular_mvp.base.client.presenters;

import org.example.modular_mvp.base.client.presenters.BuiltInContentPresenter.BuiltInContentProxy;
import org.example.modular_mvp.base.client.presenters.BuiltInContentPresenter.BuiltInContentView;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

/**
 * MainPresenter
 * 
 * <p/>
 * Simple presenter which serves up some built-in content.
 * 
 * @author Rob Cernich
 */
public class BuiltInContentPresenter extends Presenter<BuiltInContentView, BuiltInContentProxy> {

    public interface BuiltInContentView extends View {
    }

    @ProxyCodeSplit
    @NameToken("builtin")
    public interface BuiltInContentProxy extends ProxyPlace<BuiltInContentPresenter> {
    }

    @Inject
    public BuiltInContentPresenter(EventBus eventBus, BuiltInContentView view, BuiltInContentProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(getEventBus(), MainPresenter.TYPE_Content, this);
    }

}
