import { Geometry } from './geometry'

export class GeometryCollection {
    type: string = "GeometryCollection";
    geometries = new Array<Geometry>();
}
