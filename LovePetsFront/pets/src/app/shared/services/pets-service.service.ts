import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pet } from '../models/pet';

@Injectable({
  providedIn: 'root',
})
export class PetsServiceService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) {}

  getPets(): Observable<any> {
    const res = this.http.get('http://localhost:8080/api/getAllPets', {
      headers: this.headers,
      responseType: 'json',
    });
    return res;
  }

  editPet(pet: Pet): Observable<any> {
    const res = this.http.post<Pet>('http://localhost:8080/editPet', pet, {
      headers: this.headers,
      responseType: 'json',
    });
    return res;
  }
  addPet(pet: Pet): Observable<any> {
    const res = this.http.post<Pet>('http://localhost:8080/api/addPet', pet, {
      headers: this.headers,
      responseType: 'json',
    });
    return res;
  }
  deletePet(id: string): Observable<any> {
    const res = this.http.post<any>(`http://localhost:8080/api/delete/${id}`, {
      headers: this.headers,
      responseType: 'json',
    });
    return res;
  }
}
