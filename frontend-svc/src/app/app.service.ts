import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './User';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  private url = '/';

  constructor(private http: HttpClient) {}

  // Add User - Create
  adduser(user: User) {
    return this.http.post<User>(`${this.url}api/add`, user);
  }

  // Get Users - Read
  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(this.url + 'api/users');
  }

  // Get User by Id - Read
  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url}api/user/${id}`);
  }

  // Update User - Update
  updateUser(id?: number, user?: any): Observable<any> {
    return this.http.put<any>(`${this.url}api/update/${id}`, user);
  }

  // Delete User - Delete
  deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`${this.url}api/delete/${id}`);
  }
}
