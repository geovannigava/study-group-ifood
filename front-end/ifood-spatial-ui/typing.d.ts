import * as L from 'leaflet';
declare module 'leaflet' {
   namespace control {
       function coordinates(v: any);
     }
}

declare var togeojson: any;

declare var tokml: any;

declare var turf: any;
