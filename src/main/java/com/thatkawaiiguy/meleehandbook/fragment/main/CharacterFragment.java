/*
    This file is part of Handbook for Melee.

    Handbook for Melee is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Handbook for Melee is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Handbook for Melee.  If not, see <http://www.gnu.org/licenses/>
 */

package com.thatkawaiiguy.meleehandbook.fragment.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thatkawaiiguy.meleehandbook.adapter.IconAdapter;
import com.thatkawaiiguy.meleehandbook.utils.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.R;

public class CharacterFragment extends Fragment {

    private IconAdapter adapter;

    public static CharacterFragment newInstance() {
        Bundle args = new Bundle();
        CharacterFragment fragment = new CharacterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        String[] characters = ArrayHelper.getCharacterArray(getActivity(), true);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new IconAdapter(characters, getActivity(), true);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    @Override
    public void onResume() {
        adapter.setCanStart(true);
        super.onResume();
    }
}
