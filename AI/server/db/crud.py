# DB 관련 CRUD 작업 함수 정의
from sqlalchemy.orm import Session
from fastapi import Depends, HTTPException, status
from fastapi.security import OAuth2PasswordBearer
from jose import JWTError, jwt

from core.config import settings

JWT_SECRET = settings.JWT_SECRET
ALGORITHM = "HS256"
