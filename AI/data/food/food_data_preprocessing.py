# ---
# jupyter:
#   jupytext:
#     formats: ipynb,py:light
#     text_representation:
#       extension: .py
#       format_name: light
#       format_version: '1.5'
#       jupytext_version: 1.16.1
#   kernelspec:
#     display_name: eatceed2
#     language: python
#     name: eatceed2
# ---

# ## 1. 라이브러리 설치

# pandas 설치
import pandas as pd

# +
# 환경변수 
from dotenv import load_dotenv
import os

load_dotenv()

file_path = os.environ.get('RAW_DATA_PATH')
# -

# ## 2. 데이터 수집
# - 데이터 수집 후 필요 속성 null이 없는 데이터셋 구축

# ### 공공 데이터 포털
# - https://www.data.go.kr/data/15100070/standard.do?recommendDataYn=Y

# csv파일 Load
try:
    df = pd.read_csv(file_path + '원본 음식 데이터/전국통합식품영양성분정보 표준데이터.csv', encoding='utf-8')
except UnicodeDecodeError:
    try:
        df = pd.read_csv(file_path + '원본 음식 데이터/전국통합식품영양성분정보 표준데이터.csv', encoding='cp949')
    except Exception as e:
        print(f"Error: {e}")

# '데이터구분명'의 값이 '음식'이고, 주어진 컬럼들에 null값이 없는 데이터 추출
required_columns = ['에너지(kcal)', '영양성분함량기준량', '단백질(g)', '지방(g)', '탄수화물(g)', '당류(g)', '나트륨(mg)', '식이섬유(g)']
filtered_df = df[(df['데이터구분명'] == '가공식품') & (df[required_columns].notnull().all(axis=1))]

# 총 인스턴스 개수 파악
total_instances = len(filtered_df)

# 총 인스턴스 개수 : 1175개
print(f"\n총 인스턴스 개수: {total_instances}개")

# +
# # 필터링된 데이터를 CSV 파일로 저장
# # utf-8-sig로 인코딩하여 한글 깨짐 방지
# filtered_df.to_csv('01_filtered_data_공공데이터.csv', index=False, encoding='utf-8-sig')
# -

# ### 식품의약품안전처
# - https://various.foodsafetykorea.go.kr/nutrient/

# **가공식품**

# Excel 파일 Load
df = pd.read_excel(file_path + '원본 음식 데이터/식품의약품안전처_가공식품.xlsx')

# 주어진 컬럼들에 null값이 없는 데이터 추출
required_columns = ['에너지\n(kcal)', '영양성분기준용량', '단백질\n(g)', '지방\n(g)', '탄수화물\n(g)', '당류\n(g)', '나트륨\n(mg)', '식이섬유\n(g)']
filtered_df = df[df[required_columns].notnull().all(axis=1)]

# 총 인스턴스 개수 파악
total_instances = len(filtered_df)

print(f"\n총 인스턴스 개수: {total_instances}개")

# +
# # 필터링된 데이터를 CSV 파일로 저장
# # utf-8-sig로 인코딩하여 한글 깨짐 방지
# filtered_df.to_csv('02_filtered_data_식품의약처_가공.csv', index=False, encoding='utf-8-sig')
# -

# **음식**

# Excel 파일 Load
df = pd.read_excel(file_path + '원본 음식 데이터/식품영양성분_음식.xlsx')

# 주어진 컬럼들에 null값이 없는 데이터 추출
required_columns = ['에너지(㎉)', '1회제공량', '단백질(g)', '지방(g)', '탄수화물(g)', '총당류(g)', '나트륨(㎎)', '총 식이섬유(g)']
filtered_df = df[df[required_columns].notnull().all(axis=1)]

# 총 인스턴스 개수 파악
total_instances = len(filtered_df)

print(f"\n총 인스턴스 개수: {total_instances}개")


# +
# # 필터링된 데이터를 CSV 파일로 저장
# # utf-8-sig로 인코딩하여 한글 깨짐 방지
# filtered_df.to_csv('03_filtered_data_식품영양성분_음식.csv', index=False, encoding='utf-8-sig')
# -

# ## 데이터 전처리
# - DB에 넣기위한 데이터 가공 수행

# ### 01.Excel을 이용하여 필요 속성의 이름 동일하게 맞추기
#     1. 식품명
#     2. 1회제공량
#     3. 에너지(kcal)
#     4. 탄수화물(g)
#     5. 단백질(g)
#     6. 지방(g)
#     7. 당류(g)
#     8. 식이섬유(g)
#     9. 나트륨(g)

# ### 02.속성명을 동일하게 하는 과정에서 데이터셋 간의 차이 해결
# - 사전에 전처리 필요한 데이터셋끼리 구조 맞추기
# - “영양성분함량기준량”을 “1회섭취참고량”의 비율로 영양성분들의 값 변경
# - 최종적으로 “1회 섭취참고량”을 “1회제공량” 속성명으로 변경한 후 “영양성분함량기준량” 속성 제거

# 전처리 함수 정의
def adjust_nutrient_values(df):
    # 컬럼에 존재하는 단위 'g' 또는 'ml' 제거 및 숫자형(실수)으로 변환
    df['영양성분함량기준량'] = df['영양성분함량기준량'].str.replace('g|ml', '', regex=True).replace('-', 0).astype(float)
    df['1회 섭취참고량'] = df['1회 섭취참고량'].str.replace('g|ml', '', regex=True).replace('-', 0).astype(float)
    
    # "영양성분함량기준량"을 "1회 섭취참고량"의 비율로 숫자형 컬럼 값 변경 (소수점 2자리까지 반올림)
    for col in df.columns:
        if df[col].dtype == 'float64' or df[col].dtype == 'int64':
            df[col] = round(df[col] * (df['1회 섭취참고량'] / df['영양성분함량기준량']), 2)
            df[col].replace('-', 0, inplace=True)
    
    return df



# ### 03.Excel을 사용하여 필요 속성을 제외한 속성 제거

# ### 04.데이터셋끼리 merge 및 동일한 식품명이 존재한다면 첫번째 데이터셋 기준으로 하여 나머지 데이터는 제외
# - 첫번째 데이터셋을 기준으로 한 이유 : 1회제공량 속성이 처음부터 존재

# ### 05. Excel을 이용하여 2차 중복제거 수행
# - 동일한 식품이지만 “식품명”의 텍스트가 조금씩 달라 중복 제거가 되지 않을 경우가 존재하기 때문에 수작업으로 제거 

# ### 06.음식 분류 모델의 라벨링 데이터와 음식명 맞추기
