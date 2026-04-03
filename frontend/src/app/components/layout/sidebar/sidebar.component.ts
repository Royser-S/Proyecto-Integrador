import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { LucideAngularModule } from 'lucide-angular';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule, RouterModule, LucideAngularModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  menuItems = [
    { id: 'dashboard', path: '/dashboard', label: 'Dashboard', icon: 'layout-dashboard' },
    { id: 'equipos', path: '/equipos', label: 'Equipos', icon: 'monitor' },
    { id: 'mantenimientos', path: '/mantenimientos', label: 'Mantenimientos', icon: 'wrench' },
    { id: 'reportes', path: '/reportes', label: 'Reportes', icon: 'file-text' }
  ];

  constructor(private authService: AuthService) {}

  onLogout() {
    console.log('Logging out...');
    this.authService.logout();
  }
}
