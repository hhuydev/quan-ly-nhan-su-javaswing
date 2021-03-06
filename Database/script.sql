USE [QLNS_SK]
GO
/****** Object:  Table [dbo].[Departments]    Script Date: 5/26/2021 10:29:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departments](
	[DepartmentID] [int] IDENTITY(1,1) NOT NULL,
	[DepartmentName] [nvarchar](150) NULL,
 CONSTRAINT [PK_Departments] PRIMARY KEY CLUSTERED 
(
	[DepartmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Employees]    Script Date: 5/26/2021 10:29:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employees](
	[EmployeeID] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeName] [nvarchar](100) NULL,
	[Username] [nvarchar](50) NULL,
	[Password] [nvarchar](100) NULL,
	[IsSystemAdmin] [bit] NULL,
	[RoleID] [int] NOT NULL,
	[ProjectID] [int] NOT NULL,
	[DepartmentID] [int] NOT NULL,
	[LocationID] [int] NOT NULL,
 CONSTRAINT [PK_Employees] PRIMARY KEY CLUSTERED 
(
	[EmployeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Locations]    Script Date: 5/26/2021 10:29:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Locations](
	[LocationID] [int] IDENTITY(1,1) NOT NULL,
	[LocationName] [nvarchar](150) NULL,
	[LocationAllowance] [float] NULL,
 CONSTRAINT [PK_Locations] PRIMARY KEY CLUSTERED 
(
	[LocationID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Projects]    Script Date: 5/26/2021 10:29:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Projects](
	[ProjectID] [int] IDENTITY(1,1) NOT NULL,
	[ProjectName] [nvarchar](150) NULL,
 CONSTRAINT [PK_Projects] PRIMARY KEY CLUSTERED 
(
	[ProjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Roles]    Script Date: 5/26/2021 10:29:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[RoleID] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](150) NULL,
	[RoleAllowance] [float] NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Transfers]    Script Date: 5/26/2021 10:29:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transfers](
	[TransferID] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeID] [int] NOT NULL,
	[IsApproved] [bit] NULL,
	[Reason] [nvarchar](1000) NULL,
	[FromProjectID] [int] NOT NULL,
	[ToProjectID] [int] NOT NULL,
	[FromDepartmentID] [int] NOT NULL,
	[ToDepartmentID] [int] NOT NULL,
	[FromLocationID] [int] NOT NULL,
	[ToLocationID] [int] NOT NULL,
	[TransferRelievingDate] [datetime] NULL,
	[TransferJoiningDate] [datetime] NULL,
	[TotalAllowance] [float] NULL,
 CONSTRAINT [PK_Transfers] PRIMARY KEY CLUSTERED 
(
	[TransferID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Departments] ON 

INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName]) VALUES (1, N'Accounting')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName]) VALUES (2, N'Administrative Accounting')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName]) VALUES (5, N'Manager')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName]) VALUES (31, N'Kios')
SET IDENTITY_INSERT [dbo].[Departments] OFF
SET IDENTITY_INSERT [dbo].[Employees] ON 

INSERT [dbo].[Employees] ([EmployeeID], [EmployeeName], [Username], [Password], [IsSystemAdmin], [RoleID], [ProjectID], [DepartmentID], [LocationID]) VALUES (1, N'A', N'a', N'123456', 1, 1, 2, 2, 1)
INSERT [dbo].[Employees] ([EmployeeID], [EmployeeName], [Username], [Password], [IsSystemAdmin], [RoleID], [ProjectID], [DepartmentID], [LocationID]) VALUES (2, N'B', N'b', N'123456', 0, 2, 4, 5, 4)
INSERT [dbo].[Employees] ([EmployeeID], [EmployeeName], [Username], [Password], [IsSystemAdmin], [RoleID], [ProjectID], [DepartmentID], [LocationID]) VALUES (30, N'phạm anh khải', NULL, N'123', 0, 6, 12, 1, 7)
INSERT [dbo].[Employees] ([EmployeeID], [EmployeeName], [Username], [Password], [IsSystemAdmin], [RoleID], [ProjectID], [DepartmentID], [LocationID]) VALUES (31, N'lê chi', NULL, N'123', 0, 4, 1, 5, 7)
INSERT [dbo].[Employees] ([EmployeeID], [EmployeeName], [Username], [Password], [IsSystemAdmin], [RoleID], [ProjectID], [DepartmentID], [LocationID]) VALUES (32, N'phạm tuấn', NULL, N'123', 0, 3, 3, 1, 3)
INSERT [dbo].[Employees] ([EmployeeID], [EmployeeName], [Username], [Password], [IsSystemAdmin], [RoleID], [ProjectID], [DepartmentID], [LocationID]) VALUES (33, N'lê phương anh', NULL, N'123', 0, 5, 4, 2, 4)
SET IDENTITY_INSERT [dbo].[Employees] OFF
SET IDENTITY_INSERT [dbo].[Locations] ON 

INSERT [dbo].[Locations] ([LocationID], [LocationName], [LocationAllowance]) VALUES (1, N'Ha Noi', 300)
INSERT [dbo].[Locations] ([LocationID], [LocationName], [LocationAllowance]) VALUES (2, N'Hoa Binh', 0)
INSERT [dbo].[Locations] ([LocationID], [LocationName], [LocationAllowance]) VALUES (3, N'NhaTrang', 550)
INSERT [dbo].[Locations] ([LocationID], [LocationName], [LocationAllowance]) VALUES (4, N'Thai Binh', 0)
INSERT [dbo].[Locations] ([LocationID], [LocationName], [LocationAllowance]) VALUES (7, N'HCM', 123.3)
SET IDENTITY_INSERT [dbo].[Locations] OFF
SET IDENTITY_INSERT [dbo].[Projects] ON 

INSERT [dbo].[Projects] ([ProjectID], [ProjectName]) VALUES (1, N'Building')
INSERT [dbo].[Projects] ([ProjectID], [ProjectName]) VALUES (2, N'Painting')
INSERT [dbo].[Projects] ([ProjectID], [ProjectName]) VALUES (3, N'Cleanning')
INSERT [dbo].[Projects] ([ProjectID], [ProjectName]) VALUES (4, N'Architecture')
INSERT [dbo].[Projects] ([ProjectID], [ProjectName]) VALUES (12, N'Decorating')
SET IDENTITY_INSERT [dbo].[Projects] OFF
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([RoleID], [RoleName], [RoleAllowance]) VALUES (1, N'CEO', 1200)
INSERT [dbo].[Roles] ([RoleID], [RoleName], [RoleAllowance]) VALUES (2, N'Contractor', 1100)
INSERT [dbo].[Roles] ([RoleID], [RoleName], [RoleAllowance]) VALUES (3, N'Construction engineer', 800)
INSERT [dbo].[Roles] ([RoleID], [RoleName], [RoleAllowance]) VALUES (4, N'Manager', 900)
INSERT [dbo].[Roles] ([RoleID], [RoleName], [RoleAllowance]) VALUES (5, N'Secretary', 800)
INSERT [dbo].[Roles] ([RoleID], [RoleName], [RoleAllowance]) VALUES (6, N'Consultant', 700)
INSERT [dbo].[Roles] ([RoleID], [RoleName], [RoleAllowance]) VALUES (7, N'Security Guard', 600)
SET IDENTITY_INSERT [dbo].[Roles] OFF
SET IDENTITY_INSERT [dbo].[Transfers] ON 

INSERT [dbo].[Transfers] ([TransferID], [EmployeeID], [IsApproved], [Reason], [FromProjectID], [ToProjectID], [FromDepartmentID], [ToDepartmentID], [FromLocationID], [ToLocationID], [TransferRelievingDate], [TransferJoiningDate], [TotalAllowance]) VALUES (14, 2, 1, N'tang luong', 2, 3, 2, 5, 2, 3, CAST(N'2020-06-07 00:00:00.000' AS DateTime), CAST(N'2021-02-01 00:00:00.000' AS DateTime), 2800)
SET IDENTITY_INSERT [dbo].[Transfers] OFF
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD  CONSTRAINT [FK_Employees_Departments] FOREIGN KEY([DepartmentID])
REFERENCES [dbo].[Departments] ([DepartmentID])
GO
ALTER TABLE [dbo].[Employees] CHECK CONSTRAINT [FK_Employees_Departments]
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD  CONSTRAINT [FK_Employees_Locations] FOREIGN KEY([LocationID])
REFERENCES [dbo].[Locations] ([LocationID])
GO
ALTER TABLE [dbo].[Employees] CHECK CONSTRAINT [FK_Employees_Locations]
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD  CONSTRAINT [FK_Employees_Projects] FOREIGN KEY([ProjectID])
REFERENCES [dbo].[Projects] ([ProjectID])
GO
ALTER TABLE [dbo].[Employees] CHECK CONSTRAINT [FK_Employees_Projects]
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD  CONSTRAINT [FK_Employees_Roles] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Roles] ([RoleID])
GO
ALTER TABLE [dbo].[Employees] CHECK CONSTRAINT [FK_Employees_Roles]
GO
ALTER TABLE [dbo].[Transfers]  WITH CHECK ADD  CONSTRAINT [FK_Transfers_Departments] FOREIGN KEY([ToDepartmentID])
REFERENCES [dbo].[Departments] ([DepartmentID])
GO
ALTER TABLE [dbo].[Transfers] CHECK CONSTRAINT [FK_Transfers_Departments]
GO
ALTER TABLE [dbo].[Transfers]  WITH CHECK ADD  CONSTRAINT [FK_Transfers_Departments1] FOREIGN KEY([FromDepartmentID])
REFERENCES [dbo].[Departments] ([DepartmentID])
GO
ALTER TABLE [dbo].[Transfers] CHECK CONSTRAINT [FK_Transfers_Departments1]
GO
ALTER TABLE [dbo].[Transfers]  WITH CHECK ADD  CONSTRAINT [FK_Transfers_Employees] FOREIGN KEY([EmployeeID])
REFERENCES [dbo].[Employees] ([EmployeeID])
GO
ALTER TABLE [dbo].[Transfers] CHECK CONSTRAINT [FK_Transfers_Employees]
GO
ALTER TABLE [dbo].[Transfers]  WITH CHECK ADD  CONSTRAINT [FK_Transfers_Locations] FOREIGN KEY([FromLocationID])
REFERENCES [dbo].[Locations] ([LocationID])
GO
ALTER TABLE [dbo].[Transfers] CHECK CONSTRAINT [FK_Transfers_Locations]
GO
ALTER TABLE [dbo].[Transfers]  WITH CHECK ADD  CONSTRAINT [FK_Transfers_Locations1] FOREIGN KEY([ToLocationID])
REFERENCES [dbo].[Locations] ([LocationID])
GO
ALTER TABLE [dbo].[Transfers] CHECK CONSTRAINT [FK_Transfers_Locations1]
GO
ALTER TABLE [dbo].[Transfers]  WITH CHECK ADD  CONSTRAINT [FK_Transfers_Projects] FOREIGN KEY([FromProjectID])
REFERENCES [dbo].[Projects] ([ProjectID])
GO
ALTER TABLE [dbo].[Transfers] CHECK CONSTRAINT [FK_Transfers_Projects]
GO
ALTER TABLE [dbo].[Transfers]  WITH CHECK ADD  CONSTRAINT [FK_Transfers_Projects1] FOREIGN KEY([ToProjectID])
REFERENCES [dbo].[Projects] ([ProjectID])
GO
ALTER TABLE [dbo].[Transfers] CHECK CONSTRAINT [FK_Transfers_Projects1]
GO
