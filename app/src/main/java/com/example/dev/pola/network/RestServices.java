/**
 * Copyright 2016 Erik Jhordan Rey.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dev.pola.network;

import com.example.dev.pola.model.PlaceMarkerResponseModel;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RestServices {

  @GET("wunderbucket/locations.json")
  Observable<PlaceMarkerResponseModel> fetchPlaceMarkers();

}
