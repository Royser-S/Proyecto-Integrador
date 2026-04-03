import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { authInterceptor } from './services/auth.interceptor';
import {
  LayoutDashboard, Monitor, Wrench, FileText, LogOut, Bell, Search,
  User, CheckCircle, AlertTriangle, XCircle, TrendingUp, Plus,
  Edit, Trash2, Filter, FileDown, Download, Server, Printer,
  ChevronLeft, ChevronRight, ChevronDown, Unplug, Inbox, Calendar,
  Box, FileSpreadsheet, LogIn, Lock, Settings, UserCircle,
  Clock, Hash, MapPin, Edit3, DownloadCloud, ArrowLeft, Info,
  LUCIDE_ICONS, LucideIconProvider
} from 'lucide-angular';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(withInterceptors([authInterceptor])),
    {
      provide: LUCIDE_ICONS,
      useFactory: () => new LucideIconProvider({
        LayoutDashboard, Monitor, Wrench, FileText, LogOut, Bell, Search,
        User, CheckCircle, AlertTriangle, XCircle, TrendingUp, Plus,
        Edit, Trash2, Filter, FileDown, Download, Server, Printer,
        ChevronLeft, ChevronRight, ChevronDown, Unplug, Inbox, Calendar,
        Box, FileSpreadsheet, LogIn, Lock, Settings, UserCircle,
        Clock, Hash, MapPin, Edit3, DownloadCloud, ArrowLeft, Info
      })
    }
  ]
};
